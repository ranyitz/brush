## Contributing
Hey! Thanks for your interest in improving brush! There are plenty of ways you can help!

Please take a moment to review this document in order to make the contribution process easy and effective for everyone involved.

## Submitting an issue
Please provide us with an issue in case you've found a bug, want a new feature, have an awesome idea, or there is something you want to discuss.

## Submitting a Pull Request
Good pull requests, such as patches, improvements, and new features, are a fantastic help. They should remain focused in scope and avoid containing unrelated commits.

## Running the tests
> The tests are written for truecolor terminals, if your terminal doesn't support truecolor, you can add the following environment variable to your shell: `export FORCE_COLOR=3`

The tests are written using [minitest](https://github.com/monix/minitest). You can run them using `sbt test`.

## Publishing
At the moment the publishing process is manual.

1. Raise the version of brush in `build.sbt`
2. Create a git tag
3. Add a new section to `CHANGELOG.md`
4. Run `sbt publishSigned` for every version (`2.12`, `2.13`, `3`)
5. Use https://s01.oss.sonatype.org/ to promote the artifacts. (Select the project, click Close from the menu, and then Release.)

I'm not sure if it's possible to automate this process, but I'll be happy to learn about it.