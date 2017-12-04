class LabelCounter {
    int _labelCount;

    LabelCounter() {
        _labelCount = 0;
    }

    String getNewLabel() {
        return "S_" + _labelCount++;
    }
}
