package com.clinica.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "clinica-bd8da.appspot.com";

    final String rutaSuperiorStorage = "clinica";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "clinica-bd8da-firebase-adminsdk-c215r-dd7679a111.json";
}
