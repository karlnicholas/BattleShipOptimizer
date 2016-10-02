# BattleShip

Optimize BattleShip shooting solutions with Apache commons.math GeneticAlgorithm.

Just a simple and quick optimization project with the favorite old BattleShip game. Uses the [GeneticAlgorithm](http://commons.apache.org/proper/commons-math/userguide/genetics.html) framework from Apache commons math project to evolve a best shooter for a single ship. 

  * Shooters use a DecisionTree that chooses a new location based on whether the prior shot hit or missed.
  * Ships are 3 pegs long and the algorithm is invoked when the first hit is made.

There was no attempt to find the optimal parameters for the Apache GeneticAlgorithm, so maybe I'll work on that later. The code could also be more compartmentalized, since a Shooter is considered a *Chromosome* but really a DecisionTree should be a Chromosome.   

A useful example project for how such a thing might be implemented in a fairly straight forward fashion. 