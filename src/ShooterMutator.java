import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.MutationPolicy;

public class ShooterMutator implements MutationPolicy {
    @Override
    public Chromosome mutate(Chromosome original) throws MathIllegalArgumentException {
        Shooter oShooter = (Shooter)original;
        DecisionTree decisionTree = oShooter.getDecisionTree().clone();
        decisionTree.mutate();
        return new Shooter(decisionTree);
    }

}
