package main

import (
	"fmt"
	"math/rand"
)

type cell struct {
	state int
}

func main() {
	gridSize, seed := getStart()
	rand.Seed(int64(seed))

	grid := createGrid(gridSize)
	printGrid(grid)
}

func printGrid(grid [][]cell) {
	for _, row := range grid {
		for _, cell_ := range row {
			if cell_.state == 0 {
				fmt.Print(" ")
			} else {
				fmt.Print("O")
			}
		}
		fmt.Println()
	}
}

func createGrid(gridSize int) (grid [][]cell) {
	for i := 0; i < gridSize; i++ {
		grid = append(grid, []cell{})
		for j := 0; j < gridSize; j++ {
			grid[i] = append(grid[i], cell{state: rand.Intn(2)})
		}
	}
	return grid
}

func getStart() (gridSize, seed int) {
	fmt.Scanf("%d %d", &gridSize, &seed)
	// fmt.Scanln() to consume whitespace

	return gridSize, seed
}
