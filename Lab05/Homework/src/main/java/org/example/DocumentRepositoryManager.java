    package org.example;

    import java.io.*;
    import java.util.ArrayList;
    import java.util.List;

    public class DocumentRepositoryManager {
        private final String mainDirectoryPath;

        public DocumentRepositoryManager(String mainDirectoryPath) {
            this.mainDirectoryPath = mainDirectoryPath;
        }

        public String getMainDirectoryPath() {
            return mainDirectoryPath;
        }

        public List<String> listSubdirectories() throws IOException {
            File mainDirectory = new File(mainDirectoryPath);
            List<String> subdirectoriesList = new ArrayList<>();
            if (mainDirectory.exists() && mainDirectory.isDirectory()) {
                File[] subdirectories = mainDirectory.listFiles(File::isDirectory);
                if (subdirectories != null) {
                    for (File subdirectory : subdirectories) {
                        subdirectoriesList.add(subdirectory.getName());
                    }
                    return subdirectoriesList;
                } else {
                    throw new IOException("Failed to list subdirectories in main directory.");
                }
            } else {
                throw new IOException("Main directory does not exist or is not a directory.");
            }
        }
        public String pathOfPerson(Person person){
            return getMainDirectoryPath() + File.separator + person.name();
        }
        public String pathOfAFileOfDirectorPerson(Person person, Document document){
            return getMainDirectoryPath() + File.separator + person.name() + File.separator + document.name() + "." + document.format();

        }

        public void addDocument(Person person, Document document, File fileToAdd) throws IOException {
            String personDirectoryPath = getMainDirectoryPath() + File.separator + person.name();
            File personDirectory = new File(personDirectoryPath);

            if (!personDirectory.exists()) {
                if (!personDirectory.mkdirs()) {
                    throw new IOException("Failed to create directory for person: " + person.name());
                }
            }

            String documentFilePath = personDirectoryPath + File.separator + document.name() + "." + document.format();
            File documentFile = new File(documentFilePath);

            try (FileInputStream inputStream = new FileInputStream(fileToAdd);
                 FileOutputStream outputStream = new FileOutputStream(documentFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = inputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, length);
                }
                System.out.println("Document " + document.name() + "." + document.format() + " saved for " + person.name());
            }
        }

        public void deleteDocument(Person person, Document document) throws IOException {
            String personDirectoryPath = getMainDirectoryPath() + File.separator + person.name();
            String documentFilePath = personDirectoryPath + File.separator + document.name() + "." + document.format();
            File documentFile = new File(documentFilePath);

            if (documentFile.exists()) {
                if (!documentFile.delete()) {
                    throw new IOException("Failed to delete document: " + document.name() + "." + document.format() + " for " + person.name());
                }
                System.out.println("Document " + document.name() + "." + document.format() + " deleted successfully for " + person.name()+ ";)");
            } else {
                System.out.println("Document " + document.name() + "." + document.format() + " does not exist for " + person.name());
            }
        }

        public List<String> listDocumentsByPerson(Person person) throws IOException {
            List<String> documentNames = new ArrayList<>();
            String personDirectoryPath = mainDirectoryPath + File.separator + person.name();
            File personDirectory = new File(personDirectoryPath);

            if (personDirectory.exists() && personDirectory.isDirectory()) {
                File[] files = personDirectory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        documentNames.add(file.getName());
                    }
                } else {
                    throw new IOException("Failed to list documents for person: " + person.name());
                }
            } else {
                throw new IOException("Person directory does not exist for: " + person.name());
            }
            return documentNames;
        }


    }
