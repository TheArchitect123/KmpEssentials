package com.architect.kmpessentials.printing.helpers

import java.awt.Image
import java.awt.image.BufferedImage

internal object ImageHelper {
    fun getScaledImage(srcImg: BufferedImage, width: Int, height: Int): BufferedImage {
        val resizedImg = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
        val g2 = resizedImg.createGraphics()
        g2.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null)
        g2.dispose()
        return resizedImg
    }
}