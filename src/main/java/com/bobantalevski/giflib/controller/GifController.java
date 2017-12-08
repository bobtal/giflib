package com.bobantalevski.giflib.controller;

import com.bobantalevski.giflib.data.GifRepository;
import com.bobantalevski.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap) {
        List<Gif> favoriteGifs = gifRepository.getAllFavorites();
        modelMap.put("gifs", favoriteGifs);

        return "favorites";
    }

    @RequestMapping("/search")
    public String searchResults(@RequestParam("q") String searchTerm, ModelMap modelMap) {
        List<Gif> gifsFound = gifRepository.searchByName(searchTerm);
        modelMap.put("gifs", gifsFound);

        return "home";
    }
}
