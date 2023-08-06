<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>AppTest Results</title>
            </head>
            <body>
                <h1>AppTest Results</h1>
                <table border="1">
                    <tr>
                        <th>Test</th>
                        <th>Status</th>
                        <th>Duration</th>
                    </tr>
                    <xsl:for-each select="//suite/test">
                        <tr>
                            <td><xsl:value-of select="@name"/></td>
                            <td>
                                <xsl:choose>
                                    <xsl:when test="@status = 'success'">
                                        <span class="success">Passed</span>
                                    </xsl:when>
                                    <xsl:when test="@status = 'failure'">
                                        <span class="failure">Failed</span>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <span class="error">Error</span>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </td>
                            <td><xsl:value-of select="@duration"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="text()"/>
</xsl:stylesheet>