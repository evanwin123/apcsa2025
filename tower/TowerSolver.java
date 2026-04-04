package tower;

public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model)
    {
        this.model = model;
        // Call the missing solve method (not this one)
        solve(model.getHeight(), 0, 2, 1);
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    private void solve(int n, int from, int to, int aux)
    {
        // base case: no disks to move, just return
        if (n == 0)
        {
            return;
        }
        // move n-1 disks from from to aux, using to as the helper
        solve(n - 1, from, aux, to);
        // move the largest remaining disk to the destination
        model.move(from, to);
        // move the n-1 disks from aux to to, using from as the helper
        solve(n - 1, aux, to, from);
    }
}