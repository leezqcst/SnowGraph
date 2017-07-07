package graphdb.extractors.miners.codesnippet.mail;

import com.google.common.collect.ImmutableList;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Segment {
    private boolean isCode;
    private List<String> sentences;

    public Segment(List<String> sentences) {
        this.sentences = sentences;
        this.isCode = false;
    }

    public Iterator<String> sentenceIterator() {
        return sentences.iterator();
    }

    public void setCode(boolean code) {
        isCode = code;
    }

    public boolean isCode() {
        return isCode;
    }

    public int getSentenceNumber() {
        return sentences.size();
    }

    public ImmutableList<String> getSentences() {
        return ImmutableList.copyOf(sentences);
    }

    public String getText() {
        return sentences.stream().collect(Collectors.joining("\n"));
    }

    public String getText(int start, int end) {
        return sentences.stream().skip(start).limit(end - start).collect(Collectors.joining("\n"));
    }
}