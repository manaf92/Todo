package se.Lexicon.Sequencers;

public interface Sequencer {
    int nextId();
    int getCurrentId();
    void setCurrentId(int id);

}
