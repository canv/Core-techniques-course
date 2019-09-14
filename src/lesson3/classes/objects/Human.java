package lesson3.classes.objects;

class Human{
    private String nickname;
    private int health;
    private int manna;

    Human withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    Human withHealth(int health) {
        this.health = health;
        return this;
    }
    Human withManna(int manna) {
        this.manna = manna;
        return this;
    }

    @Override
    public String toString() {
        return "Human{" +
                "nickname='" + nickname + '\'' +
                ", health=" + health +
                ", manna=" + manna +
                '}';
    }
    @Override
    public boolean equals(Object obj) {

        if(obj == null
                || obj.getClass()
                != this.getClass()) return false;

        Human guest = (Human) obj;
        return (this.nickname.equals(guest.nickname)
                && this.health == guest.health
                && this.manna == guest.manna);
    }
}
