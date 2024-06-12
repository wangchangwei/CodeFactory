 package cn.afterturn.gen.modular.demo.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

 /**
 * 科研论文-实体
 * @author : code-general
 * @date : 2023-05-31 08:53:26
 */
@TableName("scimag")
public class Scimag {

	private String id;

			/** Doi */
			private String doi;
	
			/** Doi2 */
			private String doi2;
	
			/** Title */
			private String title;
	
			/** Author */
			private String author;
	
			/** Year */
			private String year;
	
			/** Month */
			private String month;
	
			/** Day */
			private String day;
	
			/** Volume */
			private String volume;
	
			/** Issue */
			private String issue;
	
			/** FirstPage */
			private String firstPage;
	
			/** LastPage */
			private String lastPage;
	
			/** Journal */
			private String journal;
	
			/** Isbn */
			private String isbn;
	
			/** Issnp */
			private String issnp;
	
			/** Issne */
			private String issne;
	
			/** Md5 */
			private String md5;
	
			/** Filesize */
			private Integer filesize;
	
			/** Timeadded */
			private Date timeAdded;
	
			/** Journalid */
			private String journalid;
	
			/** Abstracturl */
			private String abstractURL;
	
			/** Attribute1 */
			private String attribute1;
	
			/** Attribute2 */
			private String attribute2;
	
			/** Attribute3 */
			private String attribute3;
	
			/** Attribute4 */
			private String attribute4;
	
			/** Attribute5 */
			private String attribute5;
	
			/** Attribute6 */
			private String attribute6;
	
			/** Visible */
			private String visible;
	
			/** Pubmedid */
			private String pubmedID;
	
			/** Pmc */
			private String pmc;
	
			/** Pii */
			private String pii;


	 public String getDoi() {
		 return doi;
	 }

	 public void setDoi(String doi) {
		 this.doi = doi;
	 }

	 public String getDoi2() {
		 return doi2;
	 }

	 public void setDoi2(String doi2) {
		 this.doi2 = doi2;
	 }

	 public String getTitle() {
		 return title;
	 }

	 public void setTitle(String title) {
		 this.title = title;
	 }

	 public String getAuthor() {
		 return author;
	 }

	 public void setAuthor(String author) {
		 this.author = author;
	 }

	 public String getYear() {
		 return year;
	 }

	 public void setYear(String year) {
		 this.year = year;
	 }

	 public String getMonth() {
		 return month;
	 }

	 public void setMonth(String month) {
		 this.month = month;
	 }

	 public String getDay() {
		 return day;
	 }

	 public void setDay(String day) {
		 this.day = day;
	 }

	 public String getVolume() {
		 return volume;
	 }

	 public void setVolume(String volume) {
		 this.volume = volume;
	 }

	 public String getIssue() {
		 return issue;
	 }

	 public void setIssue(String issue) {
		 this.issue = issue;
	 }

	 public String getFirstPage() {
		 return firstPage;
	 }

	 public void setFirstPage(String firstPage) {
		 this.firstPage = firstPage;
	 }

	 public String getLastPage() {
		 return lastPage;
	 }

	 public void setLastPage(String lastPage) {
		 this.lastPage = lastPage;
	 }

	 public String getJournal() {
		 return journal;
	 }

	 public void setJournal(String journal) {
		 this.journal = journal;
	 }

	 public String getIsbn() {
		 return isbn;
	 }

	 public void setIsbn(String isbn) {
		 this.isbn = isbn;
	 }

	 public String getIssnp() {
		 return issnp;
	 }

	 public void setIssnp(String issnp) {
		 this.issnp = issnp;
	 }

	 public String getIssne() {
		 return issne;
	 }

	 public void setIssne(String issne) {
		 this.issne = issne;
	 }

	 public String getMd5() {
		 return md5;
	 }

	 public void setMd5(String md5) {
		 this.md5 = md5;
	 }

	 public Integer getFilesize() {
		 return filesize;
	 }

	 public void setFilesize(Integer filesize) {
		 this.filesize = filesize;
	 }

	 public Date getTimeAdded() {
		 return timeAdded;
	 }

	 public void setTimeAdded(Date timeAdded) {
		 this.timeAdded = timeAdded;
	 }

	 public String getJournalid() {
		 return journalid;
	 }

	 public void setJournalid(String journalid) {
		 this.journalid = journalid;
	 }

	 public String getAbstractURL() {
		 return abstractURL;
	 }

	 public void setAbstractURL(String abstractURL) {
		 this.abstractURL = abstractURL;
	 }

	 public String getAttribute1() {
		 return attribute1;
	 }

	 public void setAttribute1(String attribute1) {
		 this.attribute1 = attribute1;
	 }

	 public String getAttribute2() {
		 return attribute2;
	 }

	 public void setAttribute2(String attribute2) {
		 this.attribute2 = attribute2;
	 }

	 public String getAttribute3() {
		 return attribute3;
	 }

	 public void setAttribute3(String attribute3) {
		 this.attribute3 = attribute3;
	 }

	 public String getAttribute4() {
		 return attribute4;
	 }

	 public void setAttribute4(String attribute4) {
		 this.attribute4 = attribute4;
	 }

	 public String getAttribute5() {
		 return attribute5;
	 }

	 public void setAttribute5(String attribute5) {
		 this.attribute5 = attribute5;
	 }

	 public String getAttribute6() {
		 return attribute6;
	 }

	 public void setAttribute6(String attribute6) {
		 this.attribute6 = attribute6;
	 }

	 public String getVisible() {
		 return visible;
	 }

	 public void setVisible(String visible) {
		 this.visible = visible;
	 }

	 public String getPubmedID() {
		 return pubmedID;
	 }

	 public void setPubmedID(String pubmedID) {
		 this.pubmedID = pubmedID;
	 }

	 public String getPmc() {
		 return pmc;
	 }

	 public void setPmc(String pmc) {
		 this.pmc = pmc;
	 }

	 public String getPii() {
		 return pii;
	 }

	 public void setPii(String pii) {
		 this.pii = pii;
	 }
 }