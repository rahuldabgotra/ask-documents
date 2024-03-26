package com.rahuldabgotra.askdocuments;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.parser.apache.pdfbox.ApachePdfBoxDocumentParser;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static dev.langchain4j.data.document.loader.FileSystemDocumentLoader.loadDocument;

@SpringBootApplication
public class AskDocumentsApplication {

	private final EmbeddingStoreIngestor embeddingStoreIngestor;

	public AskDocumentsApplication(EmbeddingStoreIngestor embeddingStoreIngestor) {
		this.embeddingStoreIngestor = embeddingStoreIngestor;
	}

	@PostConstruct
	public void init() {
		Document document = loadDocument(toPath("comparison-of-human-vs-gpt.pdf"), new ApachePdfBoxDocumentParser());
		embeddingStoreIngestor.ingest(document);
	}

	private static Path toPath(String fileName) {
		URL fileUrl = AskDocumentsApplication.class.getClassLoader().getResource(fileName);
		if (fileUrl == null) {
			throw new IllegalArgumentException("File not found: " + fileName);
		}
		try {
			return Paths.get(fileUrl.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(AskDocumentsApplication.class, args);
	}

}
