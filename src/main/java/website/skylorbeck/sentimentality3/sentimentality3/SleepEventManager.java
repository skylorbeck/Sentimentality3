package website.skylorbeck.sentimentality3.sentimentality3;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;

import java.util.List;

public class SleepEventManager {//this is needed to skip the night without all the players

    public static int percent = Ref.sleepPercent;
    public static void onTick(MinecraftServer server) {
        if (Ref.doSleepStuff) {
            server.getWorlds().forEach((world) -> {
                List<ServerPlayerEntity> players = world.getPlayers();//look for sleeping players
                int sleeping = 0;
                for (PlayerEntity p : players) {//for each player, check to see if they are asleep
                    if (p.isSleeping() && p.isSleepingLongEnough())
                        sleeping++;
                }
                if (sleeping != players.size() && sleeping * 100 / players.size() >= percent) {//if enough people are sleeping to pass the % threshold, sleep
                    sleep(world, players);
                }
            });
        }
    }

    private static void sleep(ServerWorld world, List<ServerPlayerEntity> players) {//basically a copy of minecrafts vanilla but way more simple. Probably misses something critical but I don't know.
        if(world.getGameRules().getBoolean(GameRules.DO_DAYLIGHT_CYCLE)){
            long l = world.getLevelProperties().getTimeOfDay() + 24000L;
            world.setTimeOfDay(l - l%24000);
        }
        if(world.getGameRules().getBoolean(GameRules.DO_WEATHER_CYCLE)){
            world.setWeather(0,0,false ,false);
        }

        players.forEach(p-> {
            if (p.isSleeping()) {
                p.wakeUp(false, true);
            }
        });
    }
}