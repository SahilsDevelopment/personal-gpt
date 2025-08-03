```markdown
# Personal ChatGPT Backend

A simple backend service that mimics ChatGPT functionality using the OpenAI API.

---

## Overview

This is a basic backend application built with Gradle that uses the OpenAI API to generate conversational AI responses. It runs on port 8080 and exposes endpoints for interaction.

This project is intended for personal learning and experimentation with AI-powered chatbots.

---

## Features

- Backend service only (no frontend)
- Uses OpenAI API for generating responses
- Runs on port 8080 by default
- Configurable via `.env` file for the API key

---

## Prerequisites

- Java (JDK 11 or later)
- Gradle installed
- An OpenAI API key ([sign up here](https://platform.openai.com/signup))

---

## Setup and Installation

1. Clone the repository:

```

git clone [https://github.com/SahilsDevelopment/personal-gpt.git](https://github.com/SahilsDevelopment/personal-gpt.git)

````

2. Create a `.env` file in the root directory and add your OpenAI API key:

```env
OPEN_AI_KEY=your_openai_api_key_here
```
Please run export $(xargs <.env) before building the project.
````

3. Build the project using Gradle:

```bash
./gradlew build
```

---

## Running the Application

Start the backend server with:

```bash
./gradlew bootRun
```

The server will start on `http://localhost:8080`.

---

## Usage

Send requests to the API endpoint (e.g., via `curl` or Postman).
Example:

```bash
curl -X POST http://localhost:8080/ask-ai \
  -H "Content-Type: application/json" \
  -d '{"question": "Hello, AI!"}'
```

The backend will respond with a generated message from the OpenAI API.

---

## Notes

* This project is in early development and designed for personal use.
* Ensure you monitor your OpenAI API usage to avoid unexpected costs.
* Feel free to contribute or customize the code.

---

## Contact

Created by [Sahil Mishra](https://github.com/SahilsDevelopment).
Questions or suggestions? Feel free to reach out!
