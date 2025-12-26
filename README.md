This project is a Spring Boot backend service designed to analyze images captured from a Logitech camera and uploaded via a web application. 
The backend integrates Google’s Gemini Vision API to detect and describe items present in an image.

The service exposes REST endpoints that accept image data, forward it to the Gemini multimodal model, and return a concise textual description of the image. 
Additionally, the system includes text-to-speech (TTS) functionality to audibly read the AI-generated description aloud.

This backend was developed as part of a larger application that includes a camera-based frontend and website, enabling real-time image analysis and accessibility-focused feedback.

Features: 
Image analysis using Google Gemini Vision
REST API built with Spring Boot
Accepts raw image bytes from web frontend or camera
Text-to-Speech output using Windows PowerShell

Package Structure:

├── GeminiController.java
│   ├── REST endpoints for image analysis
│   ├── Gemini API integration
│   └── Text-to-Speech functionality
