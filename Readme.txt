The machine that we focused on getting to work was the conveyor. 
To get the machine to work do the usual steps for sysJ programs (buildAll, refresh, runController, runPlant). 
Then in the gui press add bottle (this adds a bottle at the far end of the conveyor)
Pressing enable to effectively tick forward, so the bottle should move to position 1.
From this step onwards pressing enable should move the bottle through the positions of the rotary table until it reaches pos 5.
Pressing enable after the bottle reaches pos 5 will cause the bottle to leave pos 5.
after the bottle has left pos 5 another bottle can be added to the far end of the conveyor using the add bottle button. 

Please Note: There is an additional gui tab. This should show a more visual view of what is happening, with less details around the signals. 
This tab still needs work and as a result if the controller is left in the “leavingPos5” state the green circle illustrating the 
bottle might move back and forth on the screen. This is only a visual bug. 
Pressing the enable button again should cause the circle to disappear until a new bottle is added and enabled is pressed again
