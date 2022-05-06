package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Queue;

@MappedSuperclass
@Table(name = "round")
public abstract class Round implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", nullable = false)
    private long id;

    @JoinColumn(name = "victim")
    @OneToOne
    private Player victim;

    @Column(name = "isDay")
    private boolean isDay;

    @Column(name = "day")
    private int day;

    @Transient
    private PlayerQueue playerQueue;

    public Round() {
    }

    public Round(int day, boolean isDay, PlayerQueue playerQueue) {
        this.day = day;
        this.isDay = isDay;
        this.playerQueue = playerQueue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getVictim() {
        return victim;
    }

    public void setVictim(Player victim) {
        this.victim = victim;
    }

    public PlayerQueue getPlayerQueue() {
        return playerQueue;
    }

    public void setPlayerQueue(PlayerQueue playerQueue) {
        this.playerQueue = playerQueue;
    }

    public boolean isDay() {
        return isDay;
    }

    public void setIsDay(boolean isDay) {
        this.isDay = isDay;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setIsDay(int day) {
        this.day = day;
    }

    public abstract void start();
    public abstract void vote();



}
