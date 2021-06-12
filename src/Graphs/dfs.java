package Graphs;
// plunges a dfs into the graph
// start at any node
// do not revisit any so backtrack
// when dead end backtrack
// back track in a reversal

/*
* pseudo code
* n = no of nodes
* g = adjacency list of graph
* visited=[false,false,..,false]
*
* function dfs(at):
* if visited[at]:return
* visited[at]=true
* neighbours=graph[at[
* for next in neighbours:
*    dfs(next)
* //start at node zero
* start_node = 0
* dfs(start_node)
*  */

/*uses
* finding connected components
*  */

/*
* What DFS can do?
* Compute a minimum spanning tree
* Detect and find cycles in a graph
* find strongly connected components
* check if graph is bipartite
* Topologically sort the nodes of a graph
* find bridges and articulation points
* find augmenting paths in a flow network
* Generate Mazes
*  */
public class dfs {
}
