package be.ucll.dirkfalls.highscores;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Table(name = "highscores", indexes = {
        @Index(name = "score_idx", columnList = "score")
})
@Entity
public class HighscoresEntry {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int score;

    public HighscoresEntry() {}

    public HighscoresEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighscoresEntry that = (HighscoresEntry) o;
        return getScore() == that.getScore() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getScore());
    }

    @Override
    public String toString() {
        return "HighscoresEntry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
