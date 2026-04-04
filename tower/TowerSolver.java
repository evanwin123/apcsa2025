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

    // Overloaded recursive solve method
    private void solve(int n, int from, int to, int aux)
    {
        // Base case: no disks to move, just return
        if (n == 0)
        {
            return;
        }
        // Move n-1 disks from 'from' to 'aux', using 'to' as the helper
        solve(n - 1, from, aux, to);
        // Move the largest remaining disk to the destination
        model.move(from, to);
        // Move the n-1 disks from 'aux' to 'to', using 'from' as the helper
        solve(n - 1, aux, to, from);
    }
}