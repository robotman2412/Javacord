/*
 * Copyright (C) 2016 Bastian Oppermann
 *
 * This file is part of Javacord.
 *
 * Javacord is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser general Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * Javacord is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
package de.btobastian.javacord.entities.message.embed.impl;

import de.btobastian.javacord.entities.message.embed.EmbedVideo;
import de.btobastian.javacord.utils.LoggerUtil;
import org.json.JSONObject;
import org.slf4j.Logger;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * The implementation of the embed video interface.
 */
public class ImplEmbedVideo implements EmbedVideo {

    /**
     * The logger of this class.
     */
    private static final Logger logger = LoggerUtil.getLogger(ImplEmbedVideo.class);

    private String url;
    private int height;
    private int width;

    /**
     * Creates a new instance of this class.
     *
     * @param data A JSONObject containing all necessary data.
     */
    public ImplEmbedVideo(JSONObject data) {
        url = data.has("url") ? data.getString("url") : null;
        height = data.has("height") ? data.getInt("height") : -1;
        width = data.has("width") ? data.getInt("width") : -1;
    }

    @Override
    public URL getUrl() {
        if (url == null) {
            return null;
        }
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            logger.warn("Seems like the url of the embed video is malformed! Please contact the developer!", e);
            return null;
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

}