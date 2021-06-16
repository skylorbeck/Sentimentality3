# create scoreboards
scoreboard objectives add sleeping minecraft.custom:minecraft.sleep_in_bed
scoreboard objectives add awake minecraft.custom:minecraft.time_since_rest
#scoreboard objectives add playercount dummy
#scoreboard objectives add wassleeping minecraft.custom:minecraft.sleep_in_bed
#execute unless score titlesize sentimentality3 = titlesize sentimentality3 run scoreboard players set titlesize sentimentality3 0


#loop
schedule function sentimentality3:loop 2s