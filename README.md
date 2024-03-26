**Ask Documents: A Conversational Knowledge Base with OpenAI**

This repository houses the code for "ask-documents," an interactive system that allows users to upload a document and then engage in a conversation about its contents through a chat interface. It leverages the power of OpenAI's technology to provide insightful answers to your inquiries.

**How it Works**

1. **Document Upload:**
    - You can upload a document (currently supports PDFs) through the user interface.

2. **Chat with the Document:**
    - Ask questions in a chat-like interface, and the system will search for relevant information within your uploaded document.

3. **OpenAI Powers the Answers:**
    - The project utilizes OpenAI's API to convert both your uploaded document and your questions into numerical representations called embeddings. These embeddings capture the meaning of the text.
    - The system then searches for matching sections in the document based on your question's embedding.
    - Finally, OpenAI's large language model analyzes the retrieved sections and generates a human-readable response that addresses your question.

**Diagrammatic Representation**

```
+------------------+         +-----------------+         +-----------------+
| User Interface   | ------> | Upload Handler  | ------> |    Document     |
+------------------+         +-----------------+         +-----------------+
                                   |
                                   | (Parse and store document)
                                   v
+-----------------+         +-----------------+         +-----------------+
| Uploaded Doc    | ------> | Embedding Model | ------> | Embeddings      |
+-----------------+         +-----------------+         +-----------------+
                                   |
                                   | (Convert text to numerical representations)
                                   v
+-----------------+         +-----------------+
| Vector Store    | ------> |     Astra DB    |
+-----------------+         +-----------------+
                                   |
                                   | (Store embeddings)
                                   v
+-----------------+         +-----------------+         +-----------------+
| User Interface  | ------> | Chat Controller | ------> | Conversational  |
+-----------------+         +-----------------+         | Retrieval Chain |
                                   |                    +-----------------+
                                   |
                                   | (Convert user query to query embedding)
                                   v
+-----------------+         +-----------------+       
| Query Embedding | ------> |  Vector Store   |       
+-----------------+         +-----------------+       
                                   |                  
                                   | (Search for relevant text segments)    
                                   v                                        
+-----------------+         +------------------+         +-----------------+
| Retrieved Text  | ------> |   Chat Language  | ------> |  Human-Readable |
| Segments        |         |Model (e.g. GPT-3)|         |     Response    |
+-----------------+         +------------------+         +-----------------+
                                   | 
                                   | (Display response to user)
                                   v
                            +-----------------+
                            | Response        |
                            | User Interface  | 
                            +-----------------+

```


This diagram illustrates the flow of information throughout the project:

1. **User Interface:** The user interacts with the system through a chat interface.
2. **Upload Handler:** The user uploads a document (currently supports PDFs).
3. **Parse and Store Document:** The uploaded document is parsed and potentially stored.
4. **Embedding Model:** The document text is converted into numerical representations called embeddings.
5. **Vector Store (Astra DB):** The embeddings are stored in a vector store (Astra DB in this example).
6. **Chat Controller:** The user submits a question through the chat interface.
7. **Convert User Query to Query Embedding:** The user's query is converted into a query embedding using the same method as for the document text.
8. **Vector Store Search:** The query embedding is used to search for matching text segments within the vector store.
9. **Chat Language Model (e.g., GPT-3):** The retrieved text segments are fed into a large language model like GPT-3.
10. **Human-Readable Response:** The Chat Language Model analyzes the retrieved text segments and generates a human-readable response based on their content.
11. **Display Response to User:** The response is delivered to the user through the chat interface.


**Spring Boot Makes it Run**

This project is built using Spring Boot, a popular framework for building Java applications. Here's how to get it running on your local machine:

**Prerequisites:**

- Basic understanding of Artificial Intelligence concepts, especially machine learning and natural language processing.
- Familiarity with Java programming is recommended. 
- An OpenAI API key ( you can obtain one for free from [https://platform.openai.com/signup](https://platform.openai.com/signup) )

**Running the Project:**

1. Clone the Repository: Use Git to clone the "ask-documents" repository to your local machine.
2. Set Up Dependencies: Refer to the project's documentation for instructions on installing the required libraries (dependencies) using Maven.
3. Configure Your API Key:
    - Locate the `Application.properties` file within the project directory.
    - Find the property named `openai.api.key` and replace the placeholder value with your actual OpenAI API key.

4. Start the Application:
    - Navigate to the project directory in your terminal.
    - Run the command `mvn spring-boot:run` to start the application.

Once the application starts, you should be able to access the user interface (usually at http://localhost:8080) and interact with your uploaded document through the chat interface!

**Note:**
This project uses OpenAI's API, and their pricing structure may apply depending on your usage. Refer to OpenAI's documentation for details (https://openai.com/pricing).