package model;

import java.time.LocalDate;
import java.time.Period;

public class LeaseAgreement {
    private int id;
    private Apartment apartment;
    private Tenant tenant;
    private LocalDate startDate;
    private LocalDate endDate;

    public LeaseAgreement(int id, Apartment apartment, Tenant tenant, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.apartment = apartment;
        this.tenant = tenant;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() { return id; }
    public Apartment getApartment() { return apartment; }
    public Tenant getTenant() { return tenant; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public long getDurationDays() {
        // Упрощённый расчёт срока в днях
        return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }

    @Override
    public String toString() {
        return "Договор{" +
                "id=" + id +
                ", квартира=" + apartment.getId() +
                ", арендатор=" + tenant.getName() +
                ", с " + startDate + " по " + endDate +
                ", срок=" + getDurationDays() + " дней" +
                '}';
    }
}