package dotin.library_project.data.enums;

public enum BookStatus {
    BOOKABLE(1),
    NOT_BOOKABLE(0 ),;

    private int bookStatusNum;
    BookStatus(int st) {
        this.bookStatusNum = st;
    }
    public static boolean isValidEnum(String input) {
        for (BookStatus status : BookStatus.values()) {
            if (status.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}

