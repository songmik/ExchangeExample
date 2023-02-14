package com.example.exchangeex.api.model

data class ExchangeResponse (
    val RESULT : Int,
    val CUR_UNIT : String,
    val CUR_NM : String,
    val TTB : String,
    val TTS : String,
    val DEAL_BAS_R: String,
    val BKPR : String,
    val YY_EFEE_R : String,
    val TEN_DD_EFEE_R : String,
    val KFTC_DEAL_BAS_R : String,
    val KFTC_BKPR : String
    )