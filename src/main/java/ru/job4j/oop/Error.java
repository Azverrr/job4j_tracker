package ru.job4j.oop;

public class Error {
    private boolean active;
    private String message;
    private int status;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void errorInfo() {
        System.out.println("Активность " + active);
        System.out.println("Сообщение " + message);
        System.out.println("Статус " + status);
    }

    public static void main(String[] args) {
        Error firstError = new Error();
        Error secondError = new Error(false, 404, "Упс! Что-то пошло не так");
        Error thirdError = new Error(true, 333, "I'm tired");
        Error fourthError = new Error(true, 404, "Where is my brain");
        firstError.errorInfo();
        secondError.errorInfo();
        thirdError.errorInfo();
        fourthError.errorInfo();
    }
}
