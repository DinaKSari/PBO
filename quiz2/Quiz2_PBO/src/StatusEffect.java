package quiz2.Quiz2_PBO.src;
public interface StatusEffect {
    void onTurnStart(Character self);
    void onTurnEnd(Character self);
    boolean isExpired();
}
