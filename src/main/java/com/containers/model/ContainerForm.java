package com.containers.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

import static javax.persistence.CascadeType.*;

@Entity
public class ContainerForm {

    @Id
    @GeneratedValue(generator = "containerFormSeq")
    @SequenceGenerator(name = "containerFormSeq", sequenceName = "container_form_seq", allocationSize = 1)
    private Long id;
    @ManyToOne(targetEntity = Container.class, fetch = FetchType.LAZY, cascade = ALL)
    private Container container;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, cascade = ALL)
    private User user;
    private LocalDate addDate;

    public ContainerForm() {
    }

    public ContainerForm(Long id, Container container, User user, LocalDate addDate) {
        this.id = id;
        this.container = container;
        this.user = user;
        this.addDate = addDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerForm that = (ContainerForm) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(container, that.container) &&
                Objects.equals(user, that.user) &&
                Objects.equals(addDate, that.addDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, container, user, addDate);
    }

    @Override
    public String toString() {
        return "ContainerForm{" +
                "id=" + id +
                ", container=" + container +
                ", user=" + user +
                ", addDate=" + addDate +
                '}';
    }
}
