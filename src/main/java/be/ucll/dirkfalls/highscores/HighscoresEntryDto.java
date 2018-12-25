package be.ucll.dirkfalls.highscores;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class HighscoresEntryDto {
    @NotNull
    @NotEmpty
    @NotBlank
    private String name;

    @Min(0)
    @NotNull
    private int score;

    public HighscoresEntryDto() {
    }

    public HighscoresEntryDto(String name, int score) {
        this.name = name;
        this.score = score;
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
        HighscoresEntryDto that = (HighscoresEntryDto) o;
        return getScore() == that.getScore() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getScore());
    }

    @Override
    public String toString() {
        return "HighscoresEntryDto{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public HighscoresEntry convertToHighscoresEntry() {
        return new HighscoresEntry(this.name, this.score);
    }
}
