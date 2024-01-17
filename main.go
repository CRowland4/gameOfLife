package main

import (
	"fmt"
	"math/rand"
	"time"
)

type cell struct {
	state int
}

const iterations int = 1000

func main() {
	gridSize := getStart()

	grid := createGrid(gridSize)
	for i := 0; i < iterations; i++ {
		printGrid(i, grid)
		grid = iterateGrid(grid)
		time.Sleep(200 * time.Millisecond)
		fmt.Print("\033[H\033[2J")
	}

	return
}

func iterateGrid(grid [][]cell) (newGrid [][]cell) {
	for r, row := range grid {
		newGrid = append(newGrid, []cell{})
		for c, oldCell := range row {
			neighborCoordinates := getCellNeighborsCoordinates(r, c, len(grid)-1)
			newState := getNewCellState(grid, oldCell, neighborCoordinates)
			newGrid[r] = append(newGrid[r], cell{state: newState})
		}
	}

	return newGrid
}

func getNewCellState(grid [][]cell, oldCell cell, neighborCoordinates [8][2]int) (state int) {
	var liveNeighbors int
	for _, neighbor := range neighborCoordinates {
		row, col := neighbor[0], neighbor[1]
		liveNeighbors += grid[row][col].state
	}

	if (oldCell.state == 0) && (liveNeighbors == 3) {
		return 1
	}
	if (oldCell.state == 0) && (liveNeighbors != 3) {
		return 0
	}
	if (oldCell.state == 1) && (liveNeighbors == 2 || liveNeighbors == 3) {
		return 1
	}

	return 0

}

func getCellNeighborsCoordinates(row, column, maxIndex int) (neighbors [8][2]int) {
	if row == 0 && column == 0 {
		return neighborsCornerTL(maxIndex)
	}
	if row == 0 && column == maxIndex {
		return neighborsCornerTR(maxIndex)
	}
	if row == maxIndex && column == maxIndex {
		return neighborsCornerBR(maxIndex)
	}
	if row == maxIndex && column == 0 {
		return neighborsCornerBL(maxIndex)
	}
	if row == 0 {
		return neighborsEdgeT(row, column, maxIndex)
	}
	if column == maxIndex {
		return neighborsEdgeR(row, column)
	}
	if row == maxIndex {
		return neighborsEdgeB(row, column)
	}
	if column == 0 { // Left edge, not corner
		return neighborsEdgeL(row, column, maxIndex)
	}

	return neighborsCenter(row, column)
}

func printGrid(count int, grid [][]cell) {
	fmt.Printf("Generation #%d\n", count)
	fmt.Printf("Alive: %d\n", getAliveCount(grid))

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

func getAliveCount(grid [][]cell) (aliveCount int) {
	for i := 0; i < len(grid[0]); i++ {
		for j := 0; j < len(grid[0]); j++ {
			aliveCount += grid[i][j].state
		}
	}

	return aliveCount
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

func getStart() (gridSize int) {
	fmt.Scanf("%d", &gridSize)

	return gridSize
}

func neighborsCornerTL(maxIndex int) (neighbors [8][2]int) {
	return [8][2]int{
		{maxIndex, 0},
		{maxIndex, 1},
		{0, 1},
		{1, 1},
		{1, 0},
		{1, maxIndex},
		{0, maxIndex},
		{maxIndex, maxIndex},
	}
}

func neighborsCornerTR(maxIndex int) (neighbors [8][2]int) {
	return [8][2]int{
		{maxIndex, maxIndex},
		{maxIndex, 0},
		{0, 0},
		{1, 0},
		{1, maxIndex},
		{1, maxIndex - 1},
		{0, maxIndex - 1},
		{maxIndex, maxIndex - 1},
	}
}

func neighborsCornerBR(maxIndex int) (neighbors [8][2]int) {
	return [8][2]int{
		{maxIndex - 1, maxIndex},
		{maxIndex - 1, 0},
		{maxIndex, 0},
		{0, 0},
		{0, maxIndex},
		{0, maxIndex - 1},
		{maxIndex, maxIndex - 1},
		{maxIndex - 1, maxIndex - 1},
	}
}

func neighborsCornerBL(maxIndex int) (neighbors [8][2]int) {
	return [8][2]int{
		{maxIndex - 1, 0},
		{maxIndex - 1, 1},
		{maxIndex, 1},
		{0, 1},
		{0, 0},
		{0, maxIndex},
		{maxIndex, maxIndex},
		{maxIndex - 1, maxIndex},
	}
}

func neighborsEdgeT(row, column, maxIndex int) (neighbors [8][2]int) {
	return [8][2]int{
		{maxIndex, column},
		{maxIndex, column + 1},
		{row, column + 1},
		{row + 1, column + 1},
		{row + 1, column},
		{row + 1, column - 1},
		{row, column - 1},
		{maxIndex, column - 1},
	}
}

func neighborsEdgeR(row, column int) (neighbors [8][2]int) {
	return [8][2]int{
		{row - 1, column},
		{row - 1, 0},
		{row, 0},
		{row + 1, 0},
		{row + 1, column},
		{row + 1, column - 1},
		{row, column - 1},
		{row - 1, column - 1},
	}
}

func neighborsEdgeB(row, column int) (neighbors [8][2]int) {
	return [8][2]int{
		{row - 1, column},
		{row - 1, column + 1},
		{row, column + 1},
		{0, column + 1},
		{0, column},
		{0, column - 1},
		{row, column - 1},
		{row - 1, column - 1},
	}
}

func neighborsEdgeL(row, column, maxIndex int) (neighbors [8][2]int) {
	return [8][2]int{
		{row - 1, column},
		{row - 1, column + 1},
		{row, column + 1},
		{row + 1, column + 1},
		{row + 1, column},
		{row + 1, maxIndex},
		{row, maxIndex},
		{row - 1, maxIndex},
	}
}

func neighborsCenter(row, column int) (neighbors [8][2]int) {
	return [8][2]int{
		{row - 1, column},
		{row - 1, column + 1},
		{row, column + 1},
		{row + 1, column + 1},
		{row + 1, column},
		{row + 1, column - 1},
		{row, column - 1},
		{row - 1, column - 1},
	}
}
