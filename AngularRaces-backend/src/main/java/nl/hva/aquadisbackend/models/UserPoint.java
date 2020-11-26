package nl.hva.aquadisbackend.models;

import java.util.Optional;

public class UserPoint {
    private Optional<UserEntity> user;
    private int score;

    public UserPoint(Optional<UserEntity> user, int score) {
        this.user = user;
        this.score = score;
    }

    public Optional<UserEntity> getUser() {
        return user;
    }

    public void setUser(Optional<UserEntity> user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
