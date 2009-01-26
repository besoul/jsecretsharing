jsecretsharing
==============

Shamir's Secret Sharing Scheme. Java-style.

Generating Shares
-----------------

    // build 10 shares, of which 2 are required to recover the secret
    ShareBuilder builder = new ShareBuilder("I am Batman. Seriously.".getBytes(), 2, 512);
    List<Share> shares = builder.build(10);
    
    // takes 2 shares, recovers secret
    List<Share> someShares = new ArrayList<Share>();
    someShares.add(shares.get(2));
    someShares.add(shares.get(7));
    ShareCombiner combiner = new ShareCombiner(someShares);
    System.err.println(new String(combiner.combine()));
    
    // omg I'm batman
