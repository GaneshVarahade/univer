package com.Univerclassroom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import com.Univerclassroom.DTO.LibrarianDTO;


@Entity
@Table(name = "Books")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class Book implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "UniqueIdentifier")
	private long UniqueIdentifier;
		
	@Column(name= "Author")
	private String  Author;	

	@Column(name= "AuthorEmail")
	private String  AuthorEmail;	
	
	@Column(name= "AuthorAddress")
	private String  AuthorAddress;
	
	@Column(name= "Affiliation")
	private String  Affiliation;
		
	@Column(name= "ISBN")
	private long  ISBN;
	
	@Column(name= "Title")
	private String  Title;
	
	@Column(name= "SpecialSectionTitle")
	private String  SpecialSectionTitle;
	
	@Column(name= "Source")
	private String  Source;
	
	@Column(name= "PageCount")
	private long  PageCount;
	
	@Column(name= "PublicationDate")
	private String  PublicationDate;
	
	@Column(name= "PublisherName")
	private String  PublisherName;
	
	@Column(name= "Language")
	private String  Language;
	
	@Column(name= "DigitalObjectIdentifier")
	private long  DigitalObjectIdentifier;
	
	@Column(name= "PublicationType")
	private String  PublicationType;
	
	@Column(name= "BookType")
	private String  BookType;
	
	@Column(name= "DocumentType")
	private String  DocumentType;
	
	@Column(name= "Location")
	private String  Location;
	
	@Column(name= "Methodology")
	private String  Methodology;
	
	@Column(name= "SupplementalMaterial")
	private String  SupplementalMaterial;
	
	@Column(name= "AudienceType")
	private String  AudienceType;
	
	@Column(name= "ReleaseDate")
	private String  ReleaseDate;

	@Column(name= "issued")
	private boolean issued;
	
	
	
	public boolean isIssued() {
		return issued;
	}

	public void setIssued(boolean issued) {
		this.issued = issued;
	}

	public Book(){
	
	}

	public Book(LibrarianDTO librarianDTO)
	{
		this.Author=librarianDTO.getAuthor();
		this.AuthorEmail=librarianDTO.getAuthorEmail();
		this.AuthorAddress=librarianDTO.getAuthorAddress();
		this.Affiliation=librarianDTO.getAffiliation();
		this.ISBN=librarianDTO.getIsbn();
		this.Title=librarianDTO.getTitle();
		this.SpecialSectionTitle=librarianDTO.getSpecialSectionTitle();
		this.Source=librarianDTO.getSource();
		this.PageCount=librarianDTO.getPageCount();
		this.PublicationDate=librarianDTO.getPublicationDate();
		this.PublisherName=librarianDTO.getPublisherName();
		this.Language=librarianDTO.getLanguage();
		this.DigitalObjectIdentifier=librarianDTO.getDigitalObjectIdentifier();
		this.PublicationType=librarianDTO.getPublicationType();
		this.BookType=librarianDTO.getBookType();
		this.DocumentType=librarianDTO.getDocumentType();
		this.Location=librarianDTO.getLocation();
		this.Methodology=librarianDTO.getMethodology();
		this.SupplementalMaterial=librarianDTO.getSupplementalMaterial();
		this.AudienceType=librarianDTO.getAudienceType();
		this.ReleaseDate=librarianDTO.getReleaseDate();
		
	}
	
	@ManyToOne
	private   Librarian  librarian;

	
	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public long getUniqueIdentifier() {
		return UniqueIdentifier;
	}

	public void setUniqueIdentifier(long uniqueIdentifier) {
		UniqueIdentifier = uniqueIdentifier;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getAuthorEmail() {
		return AuthorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		AuthorEmail = authorEmail;
	}

	public String getAuthorAddress() {
		return AuthorAddress;
	}

	public void setAuthorAddress(String authorAddress) {
		AuthorAddress = authorAddress;
	}

	public String getAffiliation() {
		return Affiliation;
	}

	public void setAffiliation(String affiliation) {
		Affiliation = affiliation;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getSpecialSectionTitle() {
		return SpecialSectionTitle;
	}

	public void setSpecialSectionTitle(String specialSectionTitle) {
		SpecialSectionTitle = specialSectionTitle;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public long getPageCount() {
		return PageCount;
	}

	public void setPageCount(long pageCount) {
		PageCount = pageCount;
	}

	public String getPublicationDate() {
		return PublicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		PublicationDate = publicationDate;
	}

	public String getPublisherName() {
		return PublisherName;
	}

	public void setPublisherName(String publisherName) {
		PublisherName = publisherName;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public long getDigitalObjectIdentifier() {
		return DigitalObjectIdentifier;
	}

	public void setDigitalObjectIdentifier(long digitalObjectIdentifier) {
		DigitalObjectIdentifier = digitalObjectIdentifier;
	}

	public String getPublicationType() {
		return PublicationType;
	}

	public void setPublicationType(String publicationType) {
		PublicationType = publicationType;
	}

	public String getBookType() {
		return BookType;
	}

	public void setBookType(String bookType) {
		BookType = bookType;
	}

	public String getDocumentType() {
		return DocumentType;
	}

	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getMethodology() {
		return Methodology;
	}

	public void setMethodology(String methodology) {
		Methodology = methodology;
	}

	public String getSupplementalMaterial() {
		return SupplementalMaterial;
	}

	public void setSupplementalMaterial(String supplementalMaterial) {
		SupplementalMaterial = supplementalMaterial;
	}

	public String getAudienceType() {
		return AudienceType;
	}

	public void setAudienceType(String audienceType) {
		AudienceType = audienceType;
	}

	public String getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}

	
	
}
