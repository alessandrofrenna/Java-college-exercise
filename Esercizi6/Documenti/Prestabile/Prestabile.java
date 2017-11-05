interface Prestabile {
    static final boolean prestabile = true;

    Person borrowDocument(Person p);
    void unBorrow(Document doc);
    void startDate(String date);
    void endDate(String date);
    int getDalayDays();
    String getDocumentStatus();
}