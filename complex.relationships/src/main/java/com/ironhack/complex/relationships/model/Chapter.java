package com.ironhack.complex.relationships.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private String district;

    @OneToOne
    @JoinColumn(name = "president_id")
    private Member presidentId;

    @OneToMany
    @JoinColumn(name = "member_id")
    private List<Member> membersList;

    public Chapter() {
    }

    public Chapter(String name, String district, Member presidentId, List<Member> membersList) {
        this.name = name;
        this.district = district;
        this.presidentId = presidentId;
        this.membersList = membersList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresidentId() {
        return presidentId;
    }

    public void setPresidentId(Member presidentId) {
        this.presidentId = presidentId;
    }

    public List<Member> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Member> membersList) {
        this.membersList = membersList;
    }

    @Override
    public String toString() {
        return "Chapter [id=" + id + ", name=" + name + ", district=" + district + ", presidentId=" + presidentId
                + ", membersList=" + membersList + "]";
    }

}