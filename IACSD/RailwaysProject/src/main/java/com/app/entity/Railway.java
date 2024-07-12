package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="railways")
public class Railway {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long Id;
	@NotBlank(message = "Name is mandatory!")
	private String name;
	@NotNull(message = "Start Date is mandatory!")
	private LocalDate startDate;
	@NotNull(message = "End Date is mandatory!")
	private LocalDate endDate;
	@NotBlank(message = "Sourceis mandatory!")
	private String source;
	@NotBlank(message = "Destiantion is mandatory!")
	private String destination;
	@NotBlank(message = "Station Code is mandatory!")
	private String station_code;
	@NotNull(message = "Distance is mandatory!")
	private int distance;
	@NotNull(message = "Frequency is mandatory!")
	private int frequency;
	@NotNull(message = "Category is mandatory!")
	@Enumerated(EnumType.STRING)
	private Category cat;
	
	public Railway() {}
	
	public Railway(Long id, String name, LocalDate startDate, LocalDate endDate, String source, String destination,
			String station_code, int distance, int frequency, Category cat) {
		super();
		Id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.source = source;
		this.destination = destination;
		this.station_code = station_code;
		this.distance = distance;
		this.frequency = frequency;
		this.cat = cat;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getStation_code() {
		return station_code;
	}

	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Railway [Id=" + Id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", source=" + source + ", destination=" + destination + ", station_code=" + station_code
				+ ", distance=" + distance + ", frequency=" + frequency + ", cat=" + cat + "]";
	}
	
	

}
