scoreboard players set @a[scores={awake=1..}] sleeping 0
#execute store result score @p playercount if entity @p
execute as @a[scores={sleeping=1..}] run function sentimentality2:sleeping
#execute as @a[scores={wassleeping=1..}] run function sentimentality2:goodmorning
schedule function sentimentality2:loop 2s