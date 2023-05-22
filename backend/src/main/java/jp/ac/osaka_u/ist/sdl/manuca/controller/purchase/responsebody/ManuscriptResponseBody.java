package jp.ac.osaka_u.ist.sdl.manuca.controller.purchase.responsebody;

import java.util.List;

public record ManuscriptResponseBody(
    int id,
    List<String> phrase) {}
