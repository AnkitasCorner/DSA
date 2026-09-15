class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int wordIndex = 0;
        int totalWords = words.length;
      
        // Process words until all are consumed
        while (wordIndex < totalWords) {
            // Collect words that can fit in the current line
            List<String> currentLineWords = new ArrayList<>();
            currentLineWords.add(words[wordIndex]);
            int currentLineLength = words[wordIndex].length();
            wordIndex++;
          
            // Add more words to current line while they fit (including minimum single space between words)
            while (wordIndex < totalWords && 
                   currentLineLength + 1 + words[wordIndex].length() <= maxWidth) {
                currentLineLength += 1 + words[wordIndex].length();
                currentLineWords.add(words[wordIndex]);
                wordIndex++;
            }
          
            // Handle last line or single word line (left-justified)
            if (wordIndex == totalWords || currentLineWords.size() == 1) {
                String leftJustifiedText = String.join(" ", currentLineWords);
                String rightPadding = " ".repeat(maxWidth - leftJustifiedText.length());
                result.add(leftJustifiedText + rightPadding);
                continue;
            }
          
            // Calculate spaces for full justification
            // Total spaces needed = maxWidth - sum of word lengths
            int totalSpacesNeeded = maxWidth - (currentLineLength - currentLineWords.size() + 1);
            // Base spaces between each pair of words
            int baseSpacesBetweenWords = totalSpacesNeeded / (currentLineWords.size() - 1);
            // Extra spaces to distribute from left to right
            int extraSpaces = totalSpacesNeeded % (currentLineWords.size() - 1);
          
            // Build the fully justified line
            StringBuilder currentLine = new StringBuilder();
            for (int i = 0; i < currentLineWords.size() - 1; i++) {
                currentLine.append(currentLineWords.get(i));
                // Add base spaces plus one extra space for the first 'extraSpaces' gaps
                int spacesToAdd = baseSpacesBetweenWords + (i < extraSpaces ? 1 : 0);
                currentLine.append(" ".repeat(spacesToAdd));
            }
            // Append the last word without trailing spaces
            currentLine.append(currentLineWords.get(currentLineWords.size() - 1));
          
            result.add(currentLine.toString());
        }
      
        return result;
    }
}
