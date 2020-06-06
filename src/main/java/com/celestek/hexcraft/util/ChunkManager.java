package com.celestek.hexcraft.util;

import com.celestek.hexcraft.HexCraft;
import com.celestek.hexcraft.tileentity.TileQuantumObserver;
import com.google.common.collect.ImmutableSet;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;

import java.util.*;

public class ChunkManager implements ForgeChunkManager.LoadingCallback {

    public static final ChunkManager instance = new ChunkManager();

    private final HashMap<WorldLocation, ForgeChunkManager.Ticket> tickets = new HashMap();

    private ChunkManager() {

    }

    public void register() {
        ForgeChunkManager.setForcedChunkLoadingCallback(HexCraft.instance, this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void unloadWorld(WorldEvent.Unload event) {
        Iterator<WorldLocation> iterator = tickets.keySet().iterator();
        while (iterator.hasNext()) {
            WorldLocation location = iterator.next();
            if (location.dimensionID == event.world.provider.dimensionId)
                iterator.remove();
        }
    }

    @Override
    public void ticketsLoaded(List<ForgeChunkManager.Ticket> tickets, World world) {
        for (ForgeChunkManager.Ticket ticket : tickets) {
            NBTTagCompound nbt = ticket.getModData();

            int x = nbt.getInteger("tileX");
            int y = nbt.getInteger("tileY");
            int z = nbt.getInteger("tileZ");

            TileEntity tileEntity = world.getTileEntity(x, y, z);

            if (tileEntity instanceof TileQuantumObserver) {
                TileQuantumObserver tileQuantumObserver = (TileQuantumObserver) tileEntity;
                WorldLocation location = new WorldLocation(tileEntity);
                this.forceTicketChunks(ticket, tileQuantumObserver.getChunksToLoad()); //this.getChunkSquare(x, z, tile.getRadius())
                this.cacheTicket(location, ticket);
            }
            else {
                ForgeChunkManager.releaseTicket(ticket);
            }
        }
    }

    private void cacheTicket(WorldLocation location, ForgeChunkManager.Ticket ticket) {
        tickets.put(location, ticket);
    }

    public void unloadChunks(TileEntity tileEntity) {
        this.unloadChunks(new WorldLocation(tileEntity));
    }

    public void unloadChunks(WorldLocation location) {
        ForgeChunkManager.Ticket ticket = tickets.remove(location);
        //ReikaJavaLibrary.pConsole("Unloading "+ticket+" with "+ticket.getChunkList());
        ForgeChunkManager.releaseTicket(ticket);
    }

    public ForgeChunkManager.Ticket loadChunks(WorldLocation location, Collection<ChunkCoordIntPair> chunks) {
        ForgeChunkManager.Ticket ticket = tickets.get(location);
        if (ticket == null) {
            ticket = this.getNewTicket(location);
            this.cacheTicket(location, ticket);
        }
        this.forceTicketChunks(ticket, chunks);
        return ticket;
    }

    public void loadChunks(TileQuantumObserver tileQuantumObserver) {
        WorldLocation location = new WorldLocation(tileQuantumObserver);
        this.loadChunks(location, tileQuantumObserver.getChunksToLoad());
    }

    private ForgeChunkManager.Ticket getNewTicket(WorldLocation location) {
        ForgeChunkManager.Ticket ticket = ForgeChunkManager.requestTicket(HexCraft.instance, location.getWorld(), ForgeChunkManager.Type.NORMAL);

        NBTTagCompound nbt = ticket.getModData();

        nbt.setInteger("tileX", location.xCoord);
        nbt.setInteger("tileY", location.yCoord);
        nbt.setInteger("tileZ", location.zCoord);

        return ticket;
    }

    private void forceTicketChunks(ForgeChunkManager.Ticket ticket, Collection<ChunkCoordIntPair> chunks) {
        ImmutableSet<ChunkCoordIntPair> ticketChunks = ticket.getChunkList();
        //ReikaJavaLibrary.pConsole("Parsing ticket "+ticket+", world="+ticket.world+", mod="+ticket.getModId()+", chunks="+chunks);
        for (ChunkCoordIntPair coordinates : ticketChunks) {
            if (!chunks.contains(coordinates)) {
                //ReikaJavaLibrary.pConsole("Unforcing chunk "+coord.chunkXPos+", "+coord.chunkZPos);
                ForgeChunkManager.unforceChunk(ticket, coordinates);
            }
        }
        for (ChunkCoordIntPair coordinates : chunks) {
            if (!ticketChunks.contains(coordinates)) {
                //ReikaJavaLibrary.pConsole("Forcing chunk "+coord.chunkXPos+", "+coord.chunkZPos);
                ForgeChunkManager.forceChunk(ticket, coordinates);
            }
        }
    }

    /** Range is in CHUNKS, not blocks!! */
    public static Collection<ChunkCoordIntPair> getChunkSquare(int x, int z, int r) {
        int x2 = x >> 4;
        int z2 = z >> 4;
        Collection<ChunkCoordIntPair> chunkList = new ArrayList();
        for (int i = -r; i <= r; i++) {
            for (int k = -r; k <= r; k++) {
                chunkList.add(new ChunkCoordIntPair(x2+i, z2+k));
            }
        }
        return chunkList;
    }

    @Override
    public String toString() {
        return tickets.toString();
    }
}
