package irdm.indexers;

import irdm.descriptors.TextureDescriptor;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;

public class TextureIndexerEngine implements IndexerEngine {

    public static TextureIndexerEngine instance = null;

    public static TextureIndexerEngine getInstance() {
        if (instance == null)
            instance = new TextureIndexerEngine();
        return instance;
    }

    /**
     * Compute the TextureDescriptor of an image
     * @param image bufferedImage, can iterate on pixels
     * @return
     */
    @Override
    public TextureDescriptor getDescriptor(BufferedImage image) {
        /// TODO: Aya.
        return new TextureDescriptor();
    }

    @Override
    public ArrayList<IndexedImage> fetchImagesBySimilarity(IndexedImage queryImage) {
        ArrayList<IndexedImage> indexedImages = IndexedImage.fetchAllImages();

        indexedImages.sort(Comparator.comparingDouble(o -> queryImage.getTextureDescriptor().distance(o.getTextureDescriptor())));

        return indexedImages;
    }
}
