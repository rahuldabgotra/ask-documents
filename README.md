## ask-documents: A Chatty Knowledge Base with OpenAI

This repository holds the code for "ask-documents," a project that allows users to upload a document and then interact with it through a chat interface. It leverages OpenAI's powerful technology to understand and respond to your questions about the document.

**How it Works:**

1. **Upload Your Document:**
   - You can upload a document (currently supports PDFs) through the user interface.

2. **Chat with the Document:**
   - Ask questions in a chat-like interface, and the system will search for relevant information within your document.

3. **OpenAI Powers the Answers:**
   - The project utilizes the OpenAI API to convert both your uploaded document and your questions into numerical representations (embeddings). These embeddings capture the meaning of the text.
   - The system then searches for matching sections in the document based on your question's embedding.
   - Finally, OpenAI's large language model analyzes the retrieved sections and generates a human-readable response that addresses your question.

**Diagrammatic Representation:**

```
+--------------------+      +-----------------+      +-----------------+
|  User Interface  | ------> | Upload Handler  | ------> | Document       |
+--------------------+      +-----------------+      +-----------------+
                             |
                             | (Parse and store document)
                             v
+-----------------+      +-----------------+      +-----------------+
|  Uploaded Doc    | ------> | Embedding Model | ------> | Embeddings      |
+-----------------+      +-----------------+      +-----------------+
                             |
                             | (Convert text to numerical representations)
                             v
+-----------------+      +-----------------+
|  Vector Store   |      | Astra DB         |
+-----------------+      +-----------------+
                             |
                             | (Store embeddings)
                             v
+-----------------+      +-----------------+      +-----------------+
|  User Interface  | ------> | Chat Controller | ------> | Conversational  |
| (Chat interface) |      +-----------------+      | Retrieval Chain|
+-----------------+                             +-----------------+
                             |
                             | (Convert user query to query embedding)
                             v
+-----------------+      +-----------------+      +-----------------+
|  Query Embedding| ------> | Vector Store   |      | Chat Language  |
+-----------------+      +-----------------+      | Model (e.g. GPT-3)|
                             |                     +-----------------+
                             | (Search for relevant text segments)     |
                             v                                         v
+-----------------+      +-----------------+      +-----------------+
| Retrieved Text   | ------> | Chat Language  | ------> | Human-Readable |
| Segments         |      | Model (e.g. GPT-3)| ------> | Response         |
+-----------------+      +-----------------+      +-----------------+
                             |
                             v
+-----------------+      +-----------------+
|  User Interface  | <------ | Response        |
+-----------------+      +-----------------+
                             | (Display response to user)
                             v

```

This diagram illustrates the flow of information throughout the project:

1. The user uploads a document through the user interface.
2. The Upload Handler parses the document and stores it (potentially).
3. The document text is converted into embeddings using an embedding model.
4. The embeddings are stored in a vector store (Astra DB in this example).
5. The user interacts with the chat interface and poses a question.
6. The Chat Controller receives the user query.
7. The Conversational Retrieval Chain converts the user query into a query embedding using the same method as for the document text.
8. The query embedding is used to search for matching text segments within the vector store.
9. The retrieved text segments are fed into the Chat Language Model (e.g., GPT-3).
10. The Chat Language Model generates a human-readable response based on the retrieved text segments.
11. The response is delivered to the user through the user interface.

**Spring Boot Makes it Run:**

This project is built using Spring Boot, a popular framework for building Java applications. Here's how to get it running on your local machine:

**Prerequisites:**

- Basic understanding of Artificial Intelligence concepts, especially machine learning and natural language processing.
- Familiarity with Java programming is recommended.
- An OpenAI API key (you can obtain one for free from [https://platform.openai.com/signup](https://platform.openai.com/signup))

**Running the Project:**

1. Clone the Repository: Use Git to clone the "ask-documents" repository to your local machine.
2. Set Up Dependencies: Refer to the project
