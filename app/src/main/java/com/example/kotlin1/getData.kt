package com.example.kotlin1

fun getCategoryData():MutableList<Data>{
    val list = mutableListOf<Data>()
    list.add(Data(R.drawable.profile1, "Programming", "Learn Different Languages"))
    list.add(Data(R.drawable.profile2, "Art", "Explore Creative Expressions"))
    list.add(Data(R.drawable.profile1, "Cooking", "Master Culinary Skills"))
    list.add(Data(R.drawable.profile1, "Music", "Compose Melodies"))
    list.add(Data(R.drawable.profile2, "Fitness", "Achieve Peak Performance"))
    list.add(Data(R.drawable.profile2, "Writing", "Craft Compelling Stories"))
    list.add(Data(R.drawable.profile1, "Photography", "Capture Moments"))
    list.add(Data(R.drawable.profile1, "Gardening", "Grow Beautiful Plants"))
    list.add(Data(R.drawable.profile2, "Dancing", "Express Emotions Through Movement"))
    list.add(Data(R.drawable.profile2, "Travel", "Discover New Cultures"))
    list.add(Data(R.drawable.profile1, "Yoga", "Find Inner Balance"))
    list.add(Data(R.drawable.profile2, "Gaming", "Explore Virtual Worlds"))
    list.add(Data(R.drawable.profile1, "Reading", "Expand Knowledge Through Books"))
    list.add(Data(R.drawable.profile2, "Cooking", "Experiment with Flavors"))
    list.add(Data(R.drawable.profile1, "Crafts", "Create Handmade Artworks"))
    list.add(Data(R.drawable.profile1, "Sports", "Excel in Athletic Pursuits"))
    list.add(Data(R.drawable.profile1, "Coding", "Build Innovative Software"))
    list.add(Data(R.drawable.profile2, "Fashion", "Design Trendy Outfits"))
    list.add(Data(R.drawable.profile1, "Health", "Prioritize Well-being"))

    return list;
}