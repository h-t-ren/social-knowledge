package com.huaxinshengyuan.socknow.domain.enums;

public enum Field {
	abs("abs","abstract"),
	address("address","Publisher's address (usually just the city)"), 
	annote("annote","Annotation for annoted bibliography styles (not typical)"),
	author("author","The name(s) of the author(s) in the case of more than one author, separated by and"),
	booktitle("booktitle","The title od the book"),
	bibtexId("bibtexId","bibtexId"),
	charpter("chapter","The chapter number"),
	crossref("crossref","The key of the cross-reference entry"),
	copyright("copyright","copyright"),
	DOI("DOI","The Digital Object Identifier"),
	edition("edition","The edition of a book, long form (such as 'first' or 'second')"),
	editor("editor","The name(s) of the editors"),
	eprint("eprint","A specification of an electronic publication, often a preprint or a technical report"),
	howpublished("howpublished","How it was published, if the publishing method is nonstandard"),
	institution("institution","The institution that was involved in the publishing, but not necessarily the publisher"),
	ISBN("ISBN","The International Standard Book Number."),
	ISSN("ISSN","The International Standard Serial Number. Used to identify a journal."),
	journal("journal","The journal or magazine the work was published in"),
	key("key","A hidden field used for specifying or overriding the alphabetical order of entries (when the 'author' and 'editor' fields are missing). Note that this is very different from the key (mentioned just after this list) that is used to cite or cross-reference the entry."),
	keywords("keywords","keywords seperated by ,"),
	month("month","The month of publication (or, if unpublished, the month of creation)"),
	note("note","Miscellaneous extra information"),
	number("number","The 'number' of a journal, magazine, or tech-report, if applicable. (Most publications have a 'volume', but no 'number' field.)"),
	organization("organization","The conference sponsor"),
	pages("pages","Page numbers, separated either by commas or double-hyphens."),
	publisher("publisher","The publisher''s name"),
	school("school","The school where the thesis was written"),
	series("series","The series of books the book was published in (e.g. 'The Hardy Boys' or 'Lecture Notes in Computer Science')"),
	title("title","The title of the work"),
	type("type","The type of tech-report, for example, 'Research Note'"),
	url("url","The WWW address"),
	volume("volume","The volume of a journal or multi-volume book"),
	year("year","The year of publication (or, if unpublished, the year of creation)");
	
	private final String tag;   // in kilograms
    private final String descr; // in meters
    Field(String tag, String descr) {
        this.tag = tag;
        this.descr = descr;
    }
    public String tag()   { return tag; }
    public String  descr() { return descr; }



}



