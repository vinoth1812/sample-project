package automobile.demo.entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    private UUID uuid;

    private String name;
    private String email;
    private String phoneNumber; // Contact details
    private String preferences; // Could be JSON or a structured format
    private String purchaseHistory; // Could be JSON or a structured format

    @ManyToMany
    @JoinTable(
        name = "customer_car",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private Set<Car> interestedCars;

    @ElementCollection
    private Set<String> interactions; // List of interactions

    @ElementCollection
    private Set<String> feedback; // List of feedback

    @ElementCollection
    private Set<String> inquiries; // List of inquiries

    @ElementCollection
    private Set<String> followUps; // List of follow-up activities

    @PrePersist
    protected void onCreate() {
        this.uuid = UUID.randomUUID();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public String getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(String purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public Set<Car> getInterestedCars() {
        return interestedCars;
    }

    public void setInterestedCars(Set<Car> interestedCars) {
        this.interestedCars = interestedCars;
    }

    public Set<String> getInteractions() {
        return interactions;
    }

    public void setInteractions(Set<String> interactions) {
        this.interactions = interactions;
    }

    public Set<String> getFeedback() {
        return feedback;
    }

    public void setFeedback(Set<String> feedback) {
        this.feedback = feedback;
    }

    public Set<String> getInquiries() {
        return inquiries;
    }

    public void setInquiries(Set<String> inquiries) {
        this.inquiries = inquiries;
    }

    public Set<String> getFollowUps() {
        return followUps;
    }

    public void setFollowUps(Set<String> followUps) {
        this.followUps = followUps;
    }
}
