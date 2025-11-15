package com.hackathon.image_detector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.Part;
import java.nio.file.Files;
import java.nio.file.Paths;
    
    @RestController
    public class GeminiController{

        @GetMapping("/api/test-vision")
        public String runVisionTest(){
            String apiKey= "AIzaSyBSxyR1Mhxx4FYSUKJoGglQSOWLJxIchOs";

            try{
              System.out.println("GET request to /api/test-vision received!");

            Client client = Client.builder()
                .apiKey(apiKey)
                .build();

            String imagePath = "src/main/resources/test_image.jpg.webp";
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

            Content content = Content.fromParts(
                Part.fromBytes(imageBytes, "image/webp"),
                Part.fromText("What is in this image? Be concise.")
            );

            System.out.println("Sending request to Gemini...");

            GenerateContentResponse response = client.models.generateContent(
                "models/gemini-2.5-pro", 
                content,
                null 
            );

            String aiResponse = response.text();
            System.out.println("Gemini Response: " + aiResponse);
            
        
            return aiResponse;
            

        } catch (Exception e) {
            System.out.println("!!! REQUEST FAILED !!!");
            e.printStackTrace();
            return "ERROR: " + e.getMessage(); 
        }
    }
}
