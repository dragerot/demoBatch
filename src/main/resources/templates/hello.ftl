*********************************************************************
Melding: ${header.msgId!}
<#list header.bunter as bunt>
Bunter: ${bunt.buntId!}
Transaksjoner:
    <#list bunt.transaksjoner as transaksjon>
    ${transaksjon.transaksjonsId!} ${transaksjon.melding!}
    </#list>
</#list>
*********************************************************************
header.dato?datetime?string("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")}
