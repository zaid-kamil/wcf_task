package com.miniprojects.TM02_proj1;

public class VideoStore {

    private final Video[] store;
    private int videoCount;
    private static final int MAX_VIDEOS = 100;

    public VideoStore() {
        store = new Video[MAX_VIDEOS];
        videoCount = 0;
    }

    public void addVideo(String name) {
        if (videoCount < MAX_VIDEOS) {
            store[videoCount++] = new Video(name);
            System.out.println("Video \"" + name + "\" added successfully.");
        }
    }

    public void doCheckout(String name) {
        Video video = findVideo(name);
        if (video != null) {
            video.doCheckout();
            System.out.println("Video \"" + name + "\" checked out successfully.");
        }
    }

    public void doReturn(String name) {
        Video video = findVideo(name);
        if (video != null) {
            video.doReturn();
            System.out.println("Video \"" + name + "\" returned successfully.");
        }
    }

    public void receiveRating(String name, int rating) {
        Video video = findVideo(name);
        if (video != null) {
            video.receiveRating(rating);
            System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
        }
    }

    public void listInventory() {
        if (videoCount == 0) {
            System.out.println("No videos in inventory");
            return;
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Video Name\t|\tCheckout Status\t|\tRating");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < videoCount; i++) {
            System.out.println(store[i].getName() + "\t|\t"
                    + store[i].getCheckout() + "\t\t|\t"
                    + store[i].getRating());
        }
        System.out.println("--------------------------------------------------------");
    }

    private Video findVideo(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i].getName().equals(name)) {
                return store[i];
            }
        }
        System.out.println("Video \"" + name + "\" not found.");
        return null;
    }
}
